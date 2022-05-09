package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tRoleUsrAsn {
    private String roleKey;

    private int usrKey;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private int modUsrKey;

    private String state;

    private int ver;
}
