package com.ifsc.contaclique;

import android.graphics.Bitmap;

public class Planeta {
    String nome;
    //Bitmap imagem;
    Integer imagem; //são recursos da pasta drawable R.drawable.nomeDaImagem

    public Planeta(String nome, Integer imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }
}

