package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tIntrNb {
    private int usrKey;

    private int inUsrkey;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private int modUsrkey;

    private String state;

    private int ver;
}
