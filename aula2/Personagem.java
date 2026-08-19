public class Personagem {
    String nome;
    int vida;
    int forca;

    public Personagem(String nome, int vida, int forca) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
    }

    public void receberDano(int dano) {
        vida = Math.max(0, vida - dano);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void ficha() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Força: " + forca);
        System.out.println();
    }

    public void atacar(Personagem alvo) {
        System.out.println(nome + " atacou " + alvo.nome + " causando " + forca + " de dano!");
        alvo.receberDano(forca);
    }

    public static void main(String[] args) {
        Personagem heroi = new Personagem("Herói", 100, 20);
        Personagem chefe = new Personagem("Chefe", 120, 15);

        System.out.println("=== FICHAS ANTES DA BATALHA ===");
        heroi.ficha();
        chefe.ficha();

        System.out.println("=== BATALHA ===");

        while (heroi.estaVivo() && chefe.estaVivo()) {
            heroi.atacar(chefe);

            if (chefe.estaVivo()) {
                chefe.atacar(heroi);
            }
        }

        System.out.println();
        System.out.println("=== FICHAS DEPOIS DA BATALHA ===");
        heroi.ficha();
        chefe.ficha();

        if (heroi.estaVivo()) {
            System.out.println("O Herói venceu!");
        } else {
            System.out.println("O Chefe venceu!");
        }
    }
}
