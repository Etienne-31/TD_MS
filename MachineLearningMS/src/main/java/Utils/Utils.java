package Utils;

import java.util.ArrayList;

public class Utils {

    private String pythonScriptPath;
    private Integer nbArg;

    private ArrayList<String> listArg;

    public Utils(String pythonScriptPath) {
        this.pythonScriptPath = pythonScriptPath;
        this.nbArg = 0;
        this.listArg = new ArrayList<String>();
    }

    public Utils(String pythonScriptPath, Integer nbArg) {
        this.pythonScriptPath = pythonScriptPath;
        this.nbArg = nbArg;
        this.listArg = new ArrayList<String>();
    }

    public Utils(String pythonScriptPath, ArrayList<String> listArg) {
        this.pythonScriptPath = pythonScriptPath;
        this.listArg = listArg;
        this.nbArg = listArg.size();
    }

    public void addArg(String newArg){
        this.listArg.add(newArg);
        this.nbArg++;
    }

    public String getArg(int index){
        return this.listArg.get(index);
    }

    public boolean executeScript(){
        boolean executedWell = false;
        String[] cmd = new String[2+getNbArg()];
        cmd[0] = "python3"; // ou "python" selon votre configuration
        cmd[1] = this.pythonScriptPath;

        if(this.nbArg != 0){
            for(int i = 0;i<this.nbArg+1;i++ ){
                cmd[i+2] = this.listArg.get(i);
            }
        }

        // Création du processus
        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        Process process = processBuilder.start();


        return executedWell;
    }

    public Integer getNbArg() {
        return nbArg;
    }

    public void setNbArg(Integer nbArg) {
        this.nbArg = nbArg;
    }

    public String getPythonScriptPath() {
        return pythonScriptPath;
    }

    public void setPythonScriptPath(String pythonScriptPath) {
        this.pythonScriptPath = pythonScriptPath;
    }

    public ArrayList<String> getListArg() {
        return listArg;
    }

    public void setListArg(ArrayList<String> listArg) {
        this.listArg = listArg;
    }
}
