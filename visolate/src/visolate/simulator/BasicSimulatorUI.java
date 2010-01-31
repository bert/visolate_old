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

public class BasicSimulatorUI implements SimulatorUI {

  private static final String cvsid =
  "$Id: BasicSimulatorUI.java,v 1.1.1.1 2004/06/24 05:46:01 vona Exp $";


  public boolean askContinue(int line, int seq) {

    StringBuffer msgBuf = new StringBuffer();

    msgBuf.append("Continue after line ");
    msgBuf.append(Integer.toString(line));
    msgBuf.append(" ");

    if (seq >= 0) {
      msgBuf.append("(sequence number ");
      msgBuf.append(Integer.toString(seq));
      msgBuf.append(")");
    }

    msgBuf.append("[y/n]?");

    System.out.println(msgBuf.toString());

    //TBD

    return false;
  }
}
