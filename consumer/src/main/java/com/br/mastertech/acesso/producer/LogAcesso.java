package com.br.mastertech.acesso.producer;

public class LogAcesso {

    private boolean possuiAcesso;

    private Integer portaId;

    private Integer clienteId;

    public Boolean possuiAcesso() {
        return possuiAcesso;
    }

    public void setPossuiAcesso(boolean possuiAcesso) {
        this.possuiAcesso = possuiAcesso;
    }

    public Integer getPortaId() {
        return portaId;
    }

    public void setPortaId(Integer portaId) {
        this.portaId = portaId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
