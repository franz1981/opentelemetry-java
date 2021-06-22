/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.sdk.trace.internal;

import java.util.Queue;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MpscArrayQueue;
import org.jctools.queues.MpscUnboundedXaddArrayQueue;

/** Internal accessor of JCTools package for fast queues. */
public final class JcTools {

  /**
   * Returns a new bounded {@link Queue} appropriate for use with multiple producers and a single
   * consumer.
   */
  public static <T> Queue<T> newMpscArrayQueue(int capacity) {
    return new MpscArrayQueue<>(capacity);
  }

  /**
   * Returns a new unbounded {@link Queue} appropriate for use with multiple producers and a single
   * consumer.
   */
  public static <T> Queue<T> newMpscUnboundedXaddArrayQueue(int chunkSize) {
    return new MpscUnboundedXaddArrayQueue<>(chunkSize);
  }

  /**
   * Returns the capacity of the {@link Queue}, which must be a JcTools queue. We cast to the
   * implementation so callers do not need to use the shaded classes.
   */
  public static long capacity(Queue<?> queue) {
    return ((MessagePassingQueue<?>) queue).capacity();
  }

  private JcTools() {}
}
