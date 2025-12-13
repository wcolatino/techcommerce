package br.com.techcommerce.techcommerce.model;

import br.com.techcommerce.techcommerce.model.enums.Estado;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String quadra;
    private String cep;
    private String bairro;
    private String cidade;
    private Estado estado;

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
