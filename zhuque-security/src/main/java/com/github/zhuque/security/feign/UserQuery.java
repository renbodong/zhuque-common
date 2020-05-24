package com.github.zhuque.security.feign;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author zhuque
 * @version 1.0
 * @date 2020/5/17 16:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
@ToString
public class UserQuery {
    private Boolean full = false;
    private Boolean roles =false;
    private Boolean org = false;
    private Boolean station = false;
    private Boolean resource = false;

    public static UserQuery buildFull(){
        return UserQuery.builder().full(true).build();
    }

    public static UserQuery buildRoles(){
        return UserQuery.builder().roles(false).build();
    }

    public static UserQuery buildOrg(){
        return UserQuery.builder().org(false).build();
    }

    public static UserQuery buildStation(){
        return UserQuery.builder().station(false).build();
    }

    public static UserQuery buildResource(){
        return UserQuery.builder().resource(false).build();
    }




}
