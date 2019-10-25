rm -r AnalysisV*


cd EsempioV0
make
cd ..
read

cd EsempioV1
make
cd ..
read

cd EsempioV2
make
cd ..
read

java it.unimib.disco.lta.bdci.SetupBDCI EsempioV0 EsempioV0/test EsempioV1 EsempioV1/test EsempioV2/ EsempioV2/test



cd EsempioV0
GDB_CONFIG=/home/BCT/workspace_BCT_Testing/BDCI/Esempio16/AnalysisV0/BCT/BCT_DATA/BCT/conf/files/scripts/originalSoftware.gdb.config.txt
GDB="gdb -batch -silent -n -x $GDB_CONFIG --args"
$GDB ./test
cd ..


cd EsempioV1
GDB_CONFIG=/home/BCT/workspace_BCT_Testing/BDCI/Esempio16/AnalysisV1/BCT/BCT_DATA/BCT/conf/files/scripts/originalSoftware.gdb.config.txt
GDB="gdb -batch -silent -n -x $GDB_CONFIG --args"
$GDB ./test
cd ..

cd EsempioV2
GDB_CONFIG=/home/BCT/workspace_BCT_Testing/BDCI/Esempio16/AnalysisV2/BCT/BCT_DATA/BCT/conf/files/scripts/originalSoftware.gdb.config.txt
GDB="gdb -batch -silent -n -x $GDB_CONFIG --args"
$GDB ./test
cd ..


java it.unimib.disco.lta.bdci.BDCIPreprocess /home/BCT/workspace_BCT_Testing/BDCI/Esempio16/

#Per visualizzare un FSA: (al momento non vengono analizzati con Z3 ma potresti processarli tu)
#java tools.ShowFSA AnalysisV0/BCT/BCT_DATA/BCT/Models/interactionInvariants/1.fsa 

java -cp $Z3_CP:$CLASSPATH it.unimib.disco.lta.bdci.BDCI /home/BCT/workspace_BCT_Testing/BDCI/Esempio16
