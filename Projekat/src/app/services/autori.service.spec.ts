import { TestBed } from '@angular/core/testing';

import { AutoriService } from './autori.service';

describe('AutoriService', () => {
  let service: AutoriService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AutoriService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
