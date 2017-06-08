package cn.sunfit.risk.buz.api.cmd;

import cn.sunfit.risk.buz.api.beans.buz.BPRunPath;

public class ProcessHandleHelper {
    private static ThreadLocal<IExecutionCmd> processCmdLocal = new ThreadLocal<IExecutionCmd>();

    // private static ThreadLocal<ProcessMessage> processMessageLocal = new ThreadLocal();

    private static ThreadLocal<BPRunPath> backPathLocal = new ThreadLocal<BPRunPath>();

    public static void clearBackPath() {
        backPathLocal.remove();
    }

    public static void clearProcessCmd() {
        processCmdLocal.remove();
    }

    // public static void clearProcessMessage() {
    // processMessageLocal.remove();
    // }

    // public static ProcessMessage getProcessMessage() {
    // return (ProcessMessage)processMessageLocal.get();
    // }
    //
    // public static void setProcessMessage(ProcessMessage processMessage) {
    // processMessageLocal.set(processMessage);
    // }

    public static BPRunPath getBackPath() {
        return backPathLocal.get();
    }

    public static IExecutionCmd getProcessCmd() {
        return processCmdLocal.get();
    }

    public static void setBackPath(BPRunPath bpmRuPath) {
        backPathLocal.set(bpmRuPath);
    }

    public static void setProcessCmd(IExecutionCmd cmd) {
        processCmdLocal.set(cmd);
    }
}
