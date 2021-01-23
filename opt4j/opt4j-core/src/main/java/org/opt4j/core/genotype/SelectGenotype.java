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
 * You should have received a copy of the GNU Lesser General Public License
 * along with Opt4J. If not, see http://www.gnu.org/licenses/.
 */
package org.opt4j.core.genotype;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import org.opt4j.core.Genotype;

/**
 * <p>
 * The {@link SelectGenotype} selects for each index an element from the given
 * list.
 * </p>
 * <p>
 * Example problem: Draw five times from an urn which contains three balls and
 * return the ball after each draw.<br>
 * Example usage:
 * </p>
 * <blockquote><pre>
 * SelectGenotype&lt;Ball&gt; genotype = new SelectGenotype&lt;Ball&gt;(Arrays.asList(ball1, ball2, ball3));
 * genotype.init(new Random(), 5);
 * </pre></blockquote>
 * <p>
 * Example instance: [0=ball3, 1=ball2, 2=ball2, 3=ball1, 4=ball3]
* <br>
 * Example search space size: 3<sup>5</sup>
 * </p>
 * 
 * @author lukasiewycz
 * 
 * @param <V>
 *            the type of elements
 */
public class SelectGenotype<V> extends IntegerGenotype {

	private static final long serialVersionUID = 1L;

	protected final List<V> values;

	/**
	 * Constructs a {@link SelectGenotype}.
	 * 
	 * @param values
	 *            the elements to be selected
	 */
	public SelectGenotype(List<V> values) {
		super(0, values.size() - 1);
		this.values = values;
	}

	/**
	 * Constructs a {@link SelectGenotype}.
	 * 
	 * @param values
	 *            the elements to be selected
	 */
	public SelectGenotype(V[] values) {
		this(Arrays.asList(values));
	}

	/**
	 * Returns the element value of the index.
	 * 
	 * @param index
	 *            the index
	 * @return the element
	 */
	public V getValue(int index) {
		return values.get(get(index));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.genotype.IntegerGenotype#newInstance()
	 */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <G extends Genotype> G newInstance() {
		try {
			Constructor<? extends SelectGenotype> cstr = this.getClass().getConstructor(List.class);
			return (G) cstr.newInstance(values);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
