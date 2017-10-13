package pt.ipleiria.estg.dei.aed.utils;

public class Par<T1, T2> {
    private T1 primeiro;
    private T2 segundo;

    public Par(T1 primeiro, T2 segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }


    public T1 getPrimeiro() {
        return primeiro;
    }

    public T2 getSegundo() {
        return segundo;
    }

    public void setPrimeiro(T1 primeiro) {
        this.primeiro = primeiro;
    }

    public void setSegundo(T2 segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "Primeiro: " + primeiro + "   Segundo: " + segundo;
    }
}
