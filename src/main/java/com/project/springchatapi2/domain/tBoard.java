package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tBoard {

    private int brdKey;

    private String brdType;

    private String brdTitle;

    private String brdCont;

    private Date brdStartDt;

    private Date brdEndDt;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private int modUsrKey;

    private String state;

    private int ver;
}
