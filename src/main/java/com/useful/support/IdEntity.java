package com.useful.support;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * <p> Description:  </p>
 *
 * @Version 1.0
 * @Date 15/4/22
 */
@MappedSuperclass
public class IdEntity implements Serializable{
    private static final long serialVersionUID = 1L;
	public static int AUTO_ID = 1000;//起始ID
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(length=20)
    protected Long id;
    
    @Version
    private Integer optimistic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Integer getOptimistic() {
		return optimistic;
	}

	public void setOptimistic(Integer optimistic) {
		this.optimistic = optimistic;
	}
}
