package com.pc.myapp.jump.pinglunMVP;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pc on 2017/12/15.
 */

@Module
public class PlModule {
    //实例化
    private PlView plView;

    public PlModule(PlView plView) {
        this.plView = plView;
    }

    //表明该方法提供依赖对象
    @Provides
    PlView getPlView(){
        return plView;
    }
}
