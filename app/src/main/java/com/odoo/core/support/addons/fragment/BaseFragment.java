/**
 * Odoo, Open Source Management Solution
 * Copyright (C) 2012-today Odoo SA (<http:www.odoo.com>)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http:www.gnu.org/licenses/>
 *
 * Created on 30/12/14 3:29 PM
 */
package com.odoo.core.support.addons.fragment;

import android.support.v4.app.Fragment;

import com.odoo.core.orm.OModel;
import com.odoo.core.support.OUser;

public abstract class BaseFragment extends Fragment implements IBaseFragment {


    public void setTitle(String title) {
        getActivity().setTitle(title);
    }

    public OModel db() {
        Class<?> model = database();
        if (model != null) {
            return new OModel(getActivity(), null, user()).createInstance(model);
        }
        return null;
    }

    public OUser user() {
        return OUser.current(getActivity());
    }

}