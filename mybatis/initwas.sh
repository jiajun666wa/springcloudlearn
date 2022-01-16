#!/bin/bash
#was自动启停脚本，自定义基础属性值
WASSERVER=server1
USERNAME=wasadmin
PASSWORD=wasadmin
WASPATH=/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/bin
LOGPATH=/home/guest/morni.log

export WASSERVER USERNAME PASSWORD WASPATH LOGPATH
date >> $LOGPATH
echo "=====================================stop was =====================================" >> $LOGPATH

   echo "waiting for shutdown to complete" >> $LOGPATH
   $WASPATH/stopServer.sh "$WASSERVER"   -username "$USERNAME" -password "$PASSWORD" >>$LOGPATH

   count=0
   NOTES_RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep|awk '{ print $2 }' |wc -l`
   while [[ $NOTES_RUNNING -ne 0 ]] ; do
      $WASPATH/stopServer.sh "$WASSERVER"  -username "$USERNAME" -password  "$PASSWORD" >>$LOGPATH
      count=`expr $count + 1`
      sleep 30
      echo " ... Waiting "`$count * 30 `" seconds" >>$LOGPATH
      if [ $count -eq 3 ] ; then
        echo "was is still running after 2 minutes" >>$LOGPATH
        echo " .... now for the ungraceful method" >>$LOGPATH

        for i in `ps -ef| grep "$WASSERVER"  | grep -v grep | awk '{ print $2 }'`; do
             kill -9 $i
        done
        mems=`ipcs | grep  "$WASSERVER" | awk '{ print $1 $2 }' |  awk -F"m" '{ print $2 }' | awk '{ print $1 }'`
        sems=`ipcs | grep  "$WASSERVER" | awk '{ print $1 $2 }' |  awk -F"s" '{ print $2 }' | awk '{ print $1 }'`
        for j in $mems;do
          if [ -n "$j" ] ; then
            ipcrm -m $j;
          fi;
        done
        for j in $sems;do
          if [ -n "$j" ] ; then
            ipcrm -s $j;
          fi;
        done

        echo " "$WASSERVER"  TERMINATED" >>$LOGPATH
      fi

      NOTES_RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep|awk '{ print $2 }' |wc -l`
      echo "was  shutdown completed in "$count" times " >>$LOGPATH

    done #循环判断结束

echo "was  shutdown completed already!" >>$LOGPATH

sleep 10  #s1eep 10s 后开始启动was
echo "=====================================start was =====================================" >> $LOGPATH

$WASPATH/startServer.sh "$WASSERVER" >>$LOGPATH

RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep |awk '{ print $2 }'|wc -l`
if [ $RUNNING -eq 0 ] ; then
     count=0
     NOTES_RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep|awk '{ print $2 }' |wc -l`
     while [[ $NOTES_RUNNING  -eq 0 ]] ; do
        count=`expr $count + 1`
        echo " ... Waiting "`$count * 30 `" seconds" >>$LOGPATH
        sleep 30
        $WASPATH/startServer.sh "$WASSERVER" >>$LOGPATH
        if [ $count -eq 3 ] ; then
          echo " start was 3 times, "$WASSERVER"  was terminated " >>$LOGPATH
          exit
        fi

        NOTES_RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep|awk '{ print $2 }' |wc -l`
    done  #循环判断结束

    echo "===============was  start "$count" times complet !===============" >>$LOGPATH
else
    echo "===============was  start  complet ! the pid= "$RUNNING" ===============" >>$LOGPATH
fi

