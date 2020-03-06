package com.xr.bos.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * 宣传表
 */
@Data
@Component
public class Dis_propagandatask {
    private Integer id;
    private String outline;
    private Date releaseTime;
    private Date failureTime;
    private Integer status;
    private String content;

    public Dis_propagandatask() {
    }

    public Dis_propagandatask(Integer id, String qutline, Date releaseTime, Date failureTime, Integer status, String content) {
        this.id = id;
        this.outline = qutline;
        this.releaseTime = releaseTime;
        this.failureTime = failureTime;
        this.status = status;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Dis_propagandatask{" +
                "id=" + id +
                ", qutline='" + outline + '\'' +
                ", releaseTime=" + releaseTime +
                ", failureTime=" + failureTime +
                ", status=" + status +
                ", content='" + content + '\'' +
                '}';
    }
}
