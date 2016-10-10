/*
 * Lilith - a log event viewer.
 * Copyright (C) 2007-2016 Joern Huxhorn
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.huxhorn.lilith.swing.actions;

import de.huxhorn.lilith.conditions.MarkerContainsCondition;
import de.huxhorn.sulky.conditions.Condition;

public class FocusMarkerAction
		extends AbstractLoggingFilterAction
{
	private static final long serialVersionUID = -4897396873005451863L;

	private String markerName;

	public FocusMarkerAction(String markerName)
	{
		super(markerName, false);
		this.markerName = markerName;
	}

	@Override
	protected void updateState()
	{
		if(loggingEvent == null || loggingEvent.getMarker() == null)
		{
			setEnabled(false);
			return;
		}
		setEnabled(true);
	}

	@Override
	public Condition resolveCondition()
	{
		if(loggingEvent == null || loggingEvent.getMarker() == null)
		{
			return null;
		}
		return new MarkerContainsCondition(markerName);
	}
}
