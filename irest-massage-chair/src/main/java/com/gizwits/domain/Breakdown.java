package com.gizwits.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Marvel
 * 
 * 设备故障
 */
@Entity
@Table(name = "Breakdowns")
public class Breakdown {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // 故障类型
    @ManyToOne
    private BreakdownType breakdownType;
    
    protected Breakdown() {}

    public BreakdownType getBreakdownType() {
        return breakdownType;
    }

    public void setBreakdownType(BreakdownType breakdownType) {
        this.breakdownType = breakdownType;
    }
    
}
