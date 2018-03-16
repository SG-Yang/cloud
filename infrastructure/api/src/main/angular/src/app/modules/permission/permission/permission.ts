export class Permission {
  public constructor(public code: string,
                     public desc: string,
                     public id?: number,
                     public createdBy?: number,
                     public updatedBy?: number,
                     public createdDate?: Date,
                     public updatedDate?: Date) {
  }
}
