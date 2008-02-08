package com.apress.progwt.client.service.remote;

import com.apress.progwt.client.domain.dto.UserAndToken;
import com.apress.progwt.client.exception.BusinessException;
import com.google.gwt.user.client.rpc.RemoteService;

public interface GWTUserService extends RemoteService {

    UserAndToken getCurrentUser() throws BusinessException;

}
