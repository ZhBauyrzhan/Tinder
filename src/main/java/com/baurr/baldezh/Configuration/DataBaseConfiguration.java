package com.baurr.baldezh.Configuration;

import com.j256.ormlite.support.ConnectionSource;

public interface DataBaseConfiguration {
    ConnectionSource connectionSource();
}
