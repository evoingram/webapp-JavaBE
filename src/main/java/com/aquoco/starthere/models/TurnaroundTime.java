package com.aquoco.starthere.models;

import com.aquoco.starthere.logging.Loggable;

import javax.persistence.*;

/*
 * turnaroundtimes table fields: ttid, turnaroundtime
 */
@Loggable
@Entity
@Table(name = "turnaroundtimes")
public class TurnaroundTime
        extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ttid;

    @Column(nullable = false,
            unique = true)
    private int turnaroundtime;


    public TurnaroundTime() {
    }

    public TurnaroundTime(int turnaroundtime) {
        this.turnaroundtime = turnaroundtime;
    }

    public long getTtid() {
        return ttid;
    }

    public void setTtid(long ttid) {
        this.ttid = ttid;
    }

    public int getTurnaroundtime() {
        return turnaroundtime;
    }

    public void setTurnaroundtime(int turnaroundtime) {
        this.turnaroundtime = turnaroundtime;
    }

    @Override
    public String toString() {
        return "TurnaroundTime{" +
                "ttid=" + ttid +
                ", turnaroundtime='" + turnaroundtime + '\'' +
                '}';
    }

}
