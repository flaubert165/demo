package com.example.demo.domain;

import java.util.Date;

public interface Entity {
    long getId();
    void setId(long id);
    Date getCreationDate();
    void setCreationDate(Date creationDate);
    Date getUpdateDate();
    void setUpdateDate(Date updateDate);
}
