package com.qxy.douyinDemo.mvvm.repository

import com.qxy.douyinDemo.app.AppSetting
import com.qxy.douyinDemo.base.BaseModel
import com.qxy.douyinDemo.bean.LoginInfo
import com.qxy.douyinDemo.bean.User
import com.qxy.douyinDemo.bean.VideoBean.Vbean
import com.qxy.douyinDemo.network.API
import com.qxy.douyinDemo.network.ApiResult

class RepositoryImpl : BaseModel() {
    /**
     * getAccessToken
     */
    suspend fun getToken(
        code: String
    ): ApiResult<LoginInfo> =
        request {
            API.BACKEND_SERVICE.getAccessToken(
                AppSetting.CLIENT_SECRET,
                code,
                "authorization_code",
                AppSetting.CLIENT_KEY
            )
        }
    /**
     * getUserMessage
     */
    suspend fun getMessage(access_token : String,open_id : String) : ApiResult<User> =
    request{
        API.BACKEND_SERVICE.getUserMessage(access_token,open_id)
    }
    /**
     * getVideo
     */
    suspend fun getVideo(oepn_id :String,cursor: String,count : String) :ApiResult<Vbean> =
        request {
            API.BACKEND_SERVICE.getVadio(oepn_id,cursor,count)
        }

}