//KEVEN
package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

public class Vendas {
    /*
    CREATE TABLE "venda" (
	"id_venda" serial NOT NULL,
	"data" DATE NOT NULL,
	"valor" double NOT NULL,
	"tipo_pagamento" varchar(255) NOT NULL,
	"id_produto" bigint NOT NULL,
	CONSTRAINT venda_pk PRIMARY KEY ("id_venda")
    ) WITH (
    OIDS=FALSE
    );
    */
    
    private Integer id_venda;
    private Date data;
    private double valor;
    private String tipo_pagamento;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(String tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }

    public Integer getId_venda() {
        return id_venda;
    }

    public void setId_venda(Integer id_venda) {
        this.id_venda = id_venda;
    }
    
    
    
    
}
