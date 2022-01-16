#!/bin/bash
WASSERVER=server1
USERNAME=wasadmin
PASSWORD=wasadmin
WASPATH=/opt/IBM/WebSphere/AppServer/profiles/AppSrv01/bin
LOGPATH=/itfe/logs/monitor.log
export LANG="zh_CN.GBK"
export WASSERVER USERNAME PASSWORD WASPATH LOGPATH
date >> $LOGPATH
echo "=====================================stop was =====================================" >> $LOGPATH

   echo "... waiting for shutdown to complete" >> $LOGPATH
   $WASPATH/stopServer.sh "$WASSERVER"   -username "$USERNAME" -password "$PASSWORD" >>$LOGPATH
   sleep 10
   count=1
   NOTES_RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep|awk '{ print $2 }' |wc -l`
   while [[ $NOTES_RUNNING -ne 0 ]] ; do
      $WASPATH/stopServer.sh "$WASSERVER"  -username "$USERNAME" -password  "$PASSWORD" >>$LOGPATH
      sleep 10
      count=`expr $count + 1`
      echo " ... Waiting "`expr $count \* 10`" seconds" >>$LOGPATH
      if [ $count -eq 3 ] ; then
        echo "... was is still running after"`expr $count \* 10`"seconds" >>$LOGPATH
        echo " ... now for the ungraceful method" >>$LOGPATH

        for i in `ps -ef| grep "$WASSERVER"  | grep -v grep | awk '{ print $2 }'`; do
             kill -9 $i
        done

        echo "... "$WASSERVER"  TERMINATED" >>$LOGPATH
      fi

      NOTES_RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep|awk '{ print $2 }' |wc -l`
      echo "... was try shutdown  "$count" times " >>$LOGPATH

    done

   echo "... was  shutdown completed already!" >>$LOGPATH

sleep 3  #s1eep 3s

echo "=====================================start was =====================================" >> $LOGPATH

$WASPATH/startServer.sh "$WASSERVER" >>$LOGPATH
sleep 10
RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep |awk '{ print $2 }'|wc -l`
if [ $RUNNING -eq 0 ] ; then
     count=1
     NOTES_RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep|awk '{ print $2 }' |wc -l`
     while [[ $NOTES_RUNNING  -eq 0 ]] ; do
       $WASPATH/startServer.sh "$WASSERVER" >>$LOGPATH
       sleep 10
       count=`expr $count + 1`
       echo " ... Waiting "`expr $count \* 10 `" seconds" >>$LOGPATH

      if [ $count -eq 3 ] ; then
        echo " start was 3 times, "$WASSERVER"  was terminated " >>$LOGPATH
        exit
      fi

      NOTES_RUNNING=`ps -ef | grep "$WASSERVER"  | grep -v grep|awk '{ print $2 }' |wc -l`
    done

    echo "===============was  start "$count" times complet !===============" >>$LOGPATH
else
    echo "===============was  start  complet ! the pid= "$RUNNING" ===============" >>$LOGPATH
fi
#48 23 * * * /itfe/script/timer/initwas-pro.sh