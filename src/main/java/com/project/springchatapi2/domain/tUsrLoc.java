package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tUsrLoc {

    private int locKey;

    private int usrKey;

    private String locType;

    private String locLat;

    private String locLon;

    private String locDet;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private int modUsrKey;

    private String state;

    private int ver;
}
