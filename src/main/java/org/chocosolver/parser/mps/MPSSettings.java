/**
 * This file is part of choco-parsers, https://github.com/chocoteam/choco-parsers
 *
 * Copyright (c) 2019, IMT Atlantique. All rights reserved.
 *
 * Licensed under the BSD 4-clause license.
 * See LICENSE file in the project root for full license information.
 */
package org.chocosolver.parser.mps;

import org.chocosolver.solver.DefaultSettings;
import org.chocosolver.solver.Settings;

import java.util.Properties;

/**
 * Created by cprudhom on 01/09/15.
 * Project: choco-parsers.
 */
public class MPSSettings extends DefaultSettings {

    private final boolean DEBUG = false;

    private boolean print = false;

    public MPSSettings() {
        this.setPrintConstraints(DEBUG);
        this.setWarnUser(DEBUG);
        this.setCheckDeclaredConstraints(DEBUG);
        this.setModelChecker(solver -> true);
    }

    public boolean printConstraints() {
        return false;
    }

    public Settings setPrintConstraints(boolean print) {
        this.print = print;
        return this;
    }

    @Override
    public Settings load(Properties properties) {
        super.load(properties);
        this.setPrintConstraints(Boolean.valueOf(properties.get("constraints.print").toString()));
        return this;
    }

    @Override
    public Properties store() {
        Properties properties = super.store();
        properties.setProperty("constraints.print", Boolean.toString(print));
        return properties;
    }
}
