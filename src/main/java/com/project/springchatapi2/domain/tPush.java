package com.project.springchatapi2.domain;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tPush {

    private int pushKey;

    private int usrKey;

    private String pushTypeCd;

    private String pushRefKey;

    private String pushTitle;

    private String pushMsg;

    private Date pushSendDt;

    private char pushSendDate;

    private char pushSendTime;

    private String pushSendStat;

    private String pushCfmYn;

    private int pushRetryCnt;

    private Date regDt;

    private String regUsrKey;

    private Date modDt;

    private String modUsrKey;

}
