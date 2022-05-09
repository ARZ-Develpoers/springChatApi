package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tRole {

    private String roleKey;

    private String roleNm;

    private String roleDscr;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private String modUsrKey;

    private String state;

    private int ver;
}
