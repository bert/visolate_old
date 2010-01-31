/**
 * "Visolate" -- compute (Voronoi) PCB isolation routing toolpaths
 *
 * Copyright (C) 2004 Marsette A. Vona, III
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 **/
 
package visolate.simulator;

import java.util.*;

public class LineCenterPrimitive extends MacroPrimitive {

  private static final String cvsid =
  "$Id: LineCenterPrimitive.java,v 1.1.1.1 2004/06/24 05:46:01 vona Exp $";


  public LineCenterPrimitive(final List<MacroExpression> exprs) {
    super(exprs);
  }

  public PrimitiveInstance getInstanceInternal(final List<Double> actuals) {

    int i = 0;

    int exposure = (int) getParam(i++, actuals);

    if (exposure != EXPOSURE_ON)
      return null;

    double width = getParam(i++, actuals);
    double height = getParam(i++, actuals);

    double xCenter = getParam(i++, actuals);
    double yCenter = getParam(i++, actuals);

    double rotation = getParam(i++, actuals);

    return new LineCenterInstance(width, height, xCenter, yCenter, rotation);
  }

  public String getName() {
    return "line (center)";
  }
}
