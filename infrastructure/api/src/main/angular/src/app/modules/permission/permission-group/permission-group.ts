import {Auditor} from "../../core/common/auditor";
import {Permission} from "../permission/permission";
export class PermissionGroup extends Auditor {
  public constructor(public code: string,
                     public desc: string,
                     public id?: number,
                     public createdBy?: number,
                     public updatedBy?: number,
                     public createdDate?: Date,
                     public updatedDate?: Date,
                     public permissions?: Permission[]) {
    super(id,createdBy,updatedBy,createdDate,updatedDate);
  }
}
