package com.ahb.common.region;

import com.ahb.common.domain.*;
import com.ahb.common.domain.sys.*;

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
        ViewManagerImpl viewManagerImpl = new ViewManagerImpl();
        DomainViewAssembler.Holder.INSTANCE.of().install(viewManagerImpl);
        install(viewManagerImpl);
        Command command = new Command();
        command.initProposals();
        install(command);
    }

}
