. ./bdci.config.sh

PROG=git




echo PATH:$PATH

dateStartMonitoring=$(date +"%s")



pushd $EsempioV1
P=$PATH

rm -r exec
mkdir exec
mv $PROG exec/$PROG

cd exec 
for x in `cat ../../bdci.builtin.v1.txt`;do ln git $x;done
cd ..

export PATH=$DATA/$EsempioV1:$P
export GDB_CONFIG=$DATA/AnalysisV1/BCT/BCT_DATA/BCT/conf/files/scripts/originalSoftware.gdb.config.txt
export GDB="gdb -batch -silent -n -x $GDB_CONFIG --args"

rm $DATA/$EsempioV1/bin-wrappers/git

#for x in git
#do 
#echo Setup: $x
#echo "$GDB `pwd`/exec/$x \"\$@\"" > $x
#cat ../bdci.return.0.sh >> $x
#chmod +x $x
#done
cat ../git.monitor.template | sed 's/V0/V1/g' > git
chmod +x git

for x in `cat ../bdci.builtin.v1.txt`;
do 
rm $x
ln exec/git $x
done

pwd
popd
pwd

dateEndMonitoring=$(date +"%s")
diff1=$(($dateStartMonitoring-$dateEndMonitoring))
echo "Time setup V1: $diff1"
