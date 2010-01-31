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

import javax.media.j3d.GeometryArray;

import visolate.misc.*;

public class MacroInstance extends SimObject {

  private static final String cvsid =
  "$Id: MacroInstance.java,v 1.2 2004/06/30 17:26:29 vona Exp $";


  public MacroInstance(final List<MacroPrimitive> primitives, final List<Double> modifiers) {

    for (MacroPrimitive mp : primitives) {
      PrimitiveInstance instance = mp.getInstance(modifiers);

      if (instance != null) {
        primInstances.add(instance);
      }
    }
  }

  protected void makeBounds() {
    bounds = new Rect();
    for (PrimitiveInstance prim : this.primInstances) {
      bounds.add(prim.getBounds());
    }
  }
      
  public double getWidth(double direction) {
    throw new UnsupportedOperationException("cannot draw with macro aperture");
  }

  protected void makeGeometries() {

    geometries = new LinkedList<GeometryArray>();
      
    for (Iterator<PrimitiveInstance> it = primInstances.iterator(); it.hasNext(); ) {
        
      Collection<GeometryArray> primGeoms = it.next().getGeometries();
        
      if (primGeoms != null)
        geometries.addAll(primGeoms);
    }
  }

  protected void offsetChanged() {
	  for (PrimitiveInstance prim : this.primInstances) {
		prim.setOffset(offset);
	  }
  }

  protected void inverseChanged() {
	  for (PrimitiveInstance prim : this.primInstances) {
		  prim.setInverse(inverse);
	  }
  }

  protected List<PrimitiveInstance> primInstances = new LinkedList<PrimitiveInstance>();
}
