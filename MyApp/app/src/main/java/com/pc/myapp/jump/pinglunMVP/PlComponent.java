package com.pc.myapp.jump.pinglunMVP;

import com.pc.myapp.jump.fragment.Fragment_PL;

import dagger.Component;

/**
 * Created by pc on 2017/12/15.
 */

@Component(modules = PlModule.class)
public interface PlComponent {

    //注入调用者
    void inject(Fragment_PL fragment_pl);

}
