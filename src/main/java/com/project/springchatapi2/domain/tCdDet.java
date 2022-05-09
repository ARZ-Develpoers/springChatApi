package com.project.springchatapi2.domain;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class tCdDet {
    private String cdDetKey;

    private String cdGrpKey;

    private String cdDetVal;

    private String cdDetValShort;

    private String cdDetDataType;

    private String cdDetDscr;

    private float cdDetSort;

    private Date regDt;

    private int regUsrKey;

    private Date modDt;

    private int modUsrKey;

    private String state;

    private int ver;
}
