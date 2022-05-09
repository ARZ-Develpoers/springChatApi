package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tJoin {

    private int joinKey;

    private int opKey;

    private int usr_key;

    private String jnType;

    private String jnOrdCont;

    private String jnState;

    private String jnRevCont;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private int modUsrKey;

    private String state;

    private int ver;
}
