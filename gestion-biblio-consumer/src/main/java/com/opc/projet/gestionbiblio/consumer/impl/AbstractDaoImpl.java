package com.opc.projet.gestionbiblio.consumer.impl;

import com.opc.projet.gestionbiblio.consumer.contract.AbstractDao;

import javax.sql.DataSource;


public class AbstractDaoImpl implements AbstractDao {

//    @Inject
//    @Named("dataSourceAdresse")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }
}
