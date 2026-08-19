class Personagem:
    def __init__(self, nome, vida, forca):
        self.nome = nome
        self.vida = vida
        self.forca = forca

    def receberDano(self, dano):
        self.vida = max(0, self.vida - dano)

    def estaVivo(self):
        return self.vida > 0

    def ficha(self):
        print(f"Nome: {self.nome}")
        print(f"Vida: {self.vida}")
        print(f"Força: {self.forca}")
        print()

    def atacar(self, alvo):
        print(f"{self.nome} atacou {alvo.nome} causando {self.forca} de dano!")
        alvo.receberDano(self.forca)


if __name__ == "__main__":
    heroi = Personagem("Herói", 100, 20)
    chefe = Personagem("Chefe", 120, 15)

    print("=== FICHAS ANTES DA BATALHA ===")
    heroi.ficha()
    chefe.ficha()

    print("=== BATALHA ===")

    while heroi.estaVivo() and chefe.estaVivo():
        heroi.atacar(chefe)

        if chefe.estaVivo():
            chefe.atacar(heroi)

    print()
    print("=== FICHAS DEPOIS DA BATALHA ===")
    heroi.ficha()
    chefe.ficha()

    if heroi.estaVivo():
        print("O Herói venceu!")
    else:
        print("O Chefe venceu!")
