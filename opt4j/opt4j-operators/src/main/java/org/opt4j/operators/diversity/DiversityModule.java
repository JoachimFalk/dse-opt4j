/**
 * Opt4J is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a diversity of the GNU Lesser General Public License
 * along with Opt4J. If not, see http://www.gnu.org/licenses/.
 */

package org.opt4j.operators.diversity;

import org.opt4j.core.config.Icons;
import org.opt4j.core.config.annotations.Icon;
import org.opt4j.operators.OperatorModule;

import com.google.inject.TypeLiteral;

/**
 * The {@link DiversityModule} is used for modules for the {@link Diversity}
 * operator.
 * 
 * A new {@link Diversity} operator can be registered by implementing this
 * module and adding the operator with {@link #addOperator}.
 * 
 * @author glass, lukasiewycz
 * @see Diversity
 * 
 */
@Icon(Icons.OPERATOR)
public abstract class DiversityModule extends OperatorModule<Diversity<?>> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.OperatorModule#getOperatorTypeLiteral()
	 */
	@Override
	protected TypeLiteral<Diversity<?>> getOperatorTypeLiteral() {
		return new TypeLiteral<Diversity<?>>() {
		};
	}

}