package com.church.GraceRoad;

import java.util.Dictionary;

/**
 * Created by Mac003 on 14-4-10.
 */
public class ResourceCell extends UILabel
{
    private Dictionary _info;
    public void setInfo(Dictionary info)
    {
        if (_info != info)
        {
            _info = info;
        }
    }

    public Dictionary info()
    {
        return _info;
    }
}
