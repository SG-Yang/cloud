package com.ahb.common.region;

import com.ahb.common.domain.Domain;
import com.ahb.common.domain.DomainManager;
import com.ahb.common.domain.SystemAdminDef;
import com.ahb.common.domain.ViewManagerImpl;
import com.ahb.common.domain.sys.*;
import com.ahb.common.view.BoardLayoutView;

/**
 * Created by aheroboy on 11/4/2018.
 */
public class SystemAdmin extends AbstractRegion {
    public SystemAdmin() {
        this(new SystemAdminDef());
    }

    public SystemAdmin(Domain regionDomain) {
        super(regionDomain);

        install(new RegionManager());
        install(new DomainManager());
        install(new MonitorManager());
        install(new Dashboard());
        install(new HandlerManager());
        ViewManagerImpl viewManager = new ViewManagerImpl();
        viewManager.addView(new BoardLayoutView());
        DomainViewAssembler.Holder.INSTANCE.of().install(viewManager);
        install(viewManager);
        Command command = new Command();
        command.initProposals();
        install(command);
    }

}
