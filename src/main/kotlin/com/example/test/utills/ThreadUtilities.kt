package com.example.test.utills

import org.springframework.stereotype.Component

@Component
class ThreadUtilities {
    infix fun isThreadAlive(threadId: Long?): Boolean {
        val rootGroup = getRootThreadGroup()
        val threads = getAllThreads(rootGroup)

        return threads.any {
            (it?.id ?: false) == threadId && it?.isAlive ?: false
        }
    }

    private fun getRootThreadGroup(): ThreadGroup {
        var rootGroup = Thread.currentThread().threadGroup
        while (rootGroup.parent != null) {
            rootGroup = rootGroup.parent
        }
        return rootGroup
    }

    private fun getAllThreads(rootGroup: ThreadGroup): List<Thread?> {
        val estimatedSize = rootGroup.activeCount()
        val slack = 2
        var threads = arrayOfNulls<Thread>(estimatedSize * slack)
        var nThreads: Int
        do {
            nThreads = rootGroup.enumerate(threads)
            if (nThreads == threads.size) {
                threads = arrayOfNulls(threads.size * slack)
            }
        } while (nThreads == threads.size)

        return threads.copyOf(nThreads).toList()
    }
}