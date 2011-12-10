/*
 * Copyright 2011 Bill La Forge
 *
 * This file is part of AgileWiki and is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License (LGPL) as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 * or navigate to the following url http://www.gnu.org/licenses/lgpl-2.1.txt
 *
 * Note however that only Scala, Java and JavaScript files are being covered by LGPL.
 * All other files are covered by the Common Public License (CPL).
 * A copy of this license is also included and can be
 * found as well at http://www.opensource.org/licenses/cpl1.0.txt
 */
package org.agilewiki.jactor.events;

/**
 * A EventDispatcher receives messages, queues them,
 * and then processes them on another thread.
 */
public interface EventDispatcher<E> {
    /**
     * Specifies the object which will process the dispatched events.
     * @param eventProcessor Processes the dispatched events.
     */
    public void setEventProcessor(EventProcessor<E> eventProcessor);

    /**
     * The isEmpty method returns true when there are no pending events,
     * though the results may not always be correct due to concurrency issues.
     */
    public boolean isEmpty();

    /**
     * The put method adds an events to the queue of events to be processed.
     * @param event The events to be processed.
     */
    public void put(E event);

    /**
     * The dispatchEvents method processes any events in the queue.
     * True is returned if any events were actually processed.
     */
    public boolean dispatchEvents();
}
