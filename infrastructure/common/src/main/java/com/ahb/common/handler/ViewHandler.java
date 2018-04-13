package com.ahb.common.handler;
import com.ahb.common.region.DomainViewAssembler.Holder;
import com.ahb.common.view.View;

/**
 * Created by aheroboy on 10/4/2018.
 */
public class ViewHandler extends AbstractHandler {

    public ViewHandler() {
        this(HandlerType.VIEW);
    }

    public ViewHandler(HandlerType handlerType) {
        super(handlerType);
    }

    @Override
    public Context doHandle(Context res) {
        View view = Holder.INSTANCE.of().assemble(res.getDomain());
        res.setView(view);
        return res;
    }
}
