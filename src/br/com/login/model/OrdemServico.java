/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.model;

import java.util.Date;
import org.w3c.dom.Text;

/**
 *
 * @author MiguelAspire5
 */
public class OrdemServico {
    
    Integer idos, numeroos;
    Date dataos;
    Text status, equipamento, defeito, servico, tecnico,  cliente;
    
    public OrdemServico( Integer idos, Integer numeroos, Date dataos, Text status, Text equipamento, Text defeito, Text servico, Text tecnico, Text cliente)
    {
        this.idos = idos;
        this.numeroos = numeroos;
        this.dataos = dataos;
        this.status = status;
        this.equipamento = equipamento;
        this.defeito = defeito;
        this.servico = servico;
        this.tecnico = tecnico;
        this.cliente = cliente;
    }
}
