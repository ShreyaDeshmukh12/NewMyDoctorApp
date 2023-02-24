import { TestBed } from '@angular/core/testing';

import { PatientOperationsService } from './patient-operations.service';

describe('PatientOperationsService', () => {
  let service: PatientOperationsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PatientOperationsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
