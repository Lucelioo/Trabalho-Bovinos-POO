class Fazenda {
    private Bovino boi;

    public void cadastrarBovino(int id, double peso) {
        boi = new Bovino(id, peso);
    }

    public Bovino getBovino() {
        return boi;
    }
}
